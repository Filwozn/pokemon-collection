# pokemon-collection
Webservice for collecting pokemon's cards.
##General Info
Service imitating pokemon's cards collecting build on Spring MVC.
## Table of contents
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#features)
* [Screenshots](#screenshots)
* [Examples](#examples)
## Technologies
Java 11, Spring Boot, Spring MVC, Thyemleaf, Spring Security, H2 database.
## Setup
Service is ready to deploy. Nothing to corfigurate.
## Features
You can register new account and create game avatar login and logout. Server downloads cards from Pokemon TCG Api and saves them in database. 
All avaiable cards loading.You can spend coins for card packs and buy new coins. Card pack contains 5 random cards. Purchased cards are beeing 
saved in database and attached to pokemon's trainer. 
## Screenshots
## Examples
### Example 1
```java
 public void addTrainer(TrainerDTO trainerDTO){
        validateUserHasNoTrainer();
        validateName(trainerDTO.getName());
        Trainer trainer = new Trainer(
                trainerDTO.getName(),
                trainerDTO.getType(),
                loginService.getLoggerUserMail());
        
        trainerRepository.save(trainer);
    }
```
### Example 2
```java
 protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().disable();
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/console").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/all-cards").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll();
    }
```
