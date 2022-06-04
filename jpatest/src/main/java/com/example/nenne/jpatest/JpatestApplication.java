package com.example.nenne.jpatest;

import com.example.nenne.jpatest.entity.CarwashEntity;
import com.example.nenne.jpatest.factory.CEntityManagerFactory;
import com.example.nenne.jpatest.service.InfoRepository;
import com.example.nenne.jpatest.service.UserService;
import com.example.nenne.jpatest.service.impl.UserServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

public class JpatestApplication {

	public static void main(String[] args) throws IOException {

		InfoRepository infoRepository = null;
		CEntityManagerFactory.initialization();
		UserService userService = new UserServiceImpl();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("Input your Command // [command] [name]");
			String commandLine = br.readLine();
			String[] splitCommand = commandLine.split(" ");

			// 별도 값 검증하는 로직은 추가하지 않음
			if (splitCommand[0].equalsIgnoreCase("exit")) {
				System.out.println("System closed");
				break;

			} else if (splitCommand[0].equalsIgnoreCase("insert")) {
				CarwashEntity userEntity = new CarwashEntity(Integer.parseInt(splitCommand[1]), splitCommand[2],
						splitCommand[3], Double.parseDouble(splitCommand[4]),Double.parseDouble(splitCommand[5]),Integer.parseInt(splitCommand[6]));
				userService.saveUser(userEntity);
			}
			else if (splitCommand[0].equalsIgnoreCase("select")) {
				Optional<CarwashEntity> userEntity = userService.getUser(splitCommand[1]);
				if (userEntity.isPresent()) {
					CarwashEntity user = userEntity.get();
					System.out.println("name : " + user.getNAME());
					System.out.println("address : " + user.getADDRESS());
					System.out.println("num : " + user.getNUM());

				} else {
					System.out.println("값을 찾을 수 없습니다.");
				}

			} else if(splitCommand[0].equalsIgnoreCase("list")){
				List<CarwashEntity> carwashList = infoRepository.findAll();



			} else {
				System.out.println(
						"Please input Correct Command. ex) exit, select, list");
			}
		}

		CEntityManagerFactory.close();

	}

}
