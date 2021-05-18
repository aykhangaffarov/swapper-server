package com.lab.swapper;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lab.swapper.service.FilesStorageService;

@SpringBootApplication
public class SwapperApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SwapperApplication.class, args);
	}
	 @Resource
	 FilesStorageService storageService;
	 
	@Override
	public void run(String... args) throws Exception {
		//storageService.deleteAll();
		//storageService.init();
	}
}
