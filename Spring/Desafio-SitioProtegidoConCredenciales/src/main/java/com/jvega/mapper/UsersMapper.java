package com.jvega.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jvega.model.Users;

@Mapper   //antocacion para que la interfaz  utilice Mybatis 
public interface UsersMapper {

	@Select("SELECT * FROM users WHERE email = #{email}")
	public Users findByEmail(@Param("email") String email );
}
