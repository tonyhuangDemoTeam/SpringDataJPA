package com.tonyhuang.springdata.jpaSample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class JpaSampleApplication
{
	public static void main(String[] args) {
		SpringApplication.run(JpaSampleApplication.class, args);
	}


	//1. Spring Data introduction
	//1.1 CrudRepository
	//1.2 PageAndSortRepository
	//1.3 JpaRepository
	//1.4 SimpleRepository

	//2. Spring Data JPA
	//2.1 query function construction, key words
	//2.2 pageable / sort
	//2.3 result in (stream, list, page, future)

	//3. annotation @Query @Param, @Modifying @Procedure @NamedQuery

	//4. @Entity
	//4.1 @Id, @IdClass, @Basic
	//4.2 left outer join, inner join, oneToMany, oneToOne, ManyToMany;
	// TonyHuang: not suggest use the Join in JAVA, if there is a need, use View in DB


	//5.1 QueryByExampleExecutor
	//5.2 JpaSpecificationExecutor

	//6.1 Auditing
	//6.2 Version
	//6.3 EnableJpaRepository
	//6.4 Transactional

	//7. Spring Data - Redis
	//7.1 Jedis
	//7.2 Spring Data - Cache

	//8. Spring EL

	//9. Spring Data - REST

}

