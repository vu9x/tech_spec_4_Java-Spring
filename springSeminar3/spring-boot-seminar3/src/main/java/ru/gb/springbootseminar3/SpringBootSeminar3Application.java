package ru.gb.springbootseminar3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSeminar3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSeminar3Application.class, args);

		/*
		1. Controllers (controllers, api) - входящий сигнал поступает в контроллеры. Принимает сигнал, парсит данные
		2. Services - Сервисный слой - логика. Описывать что надо сделать на конкретный сигнал.
		3. Repository, Dao - подключение к базам данных. Удаленным ресурсам
		4. Entity, Model - Сущности, запись в строке данных

		/book/**
		/reader/**
		/issue/**

		 */

	}

}
