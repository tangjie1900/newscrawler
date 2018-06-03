package com.demo.model;


import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 用户
 */
public class User {
	
	@Id
    private Integer id;
	/**手机号码*/
	@Column(nullable = false)
    private String telephone;
	/**用户密码*/
	@Column(nullable = false)
    private String password;

    
	public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}