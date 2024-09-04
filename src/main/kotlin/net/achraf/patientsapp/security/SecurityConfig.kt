package net.achraf.patientsapp.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationEntryPoint

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun inMemoryUserDetailsManager(passwordEncoder: PasswordEncoder) : InMemoryUserDetailsManager {
        val encodedPassword : String = passwordEncoder.encode("1234")
        println(encodedPassword)
        return InMemoryUserDetailsManager(
            User.withUsername("user1").password(encodedPassword).roles("USER").build(),
            User.withUsername("user2").password(encodedPassword).roles("USER").build(),
            User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("USER", "ADMIN").build()
            )
    }

    @Bean
    fun securityFilterChain(httpSecurity : HttpSecurity)  : SecurityFilterChain {
        return httpSecurity
            .formLogin(Customizer.withDefaults())
            .authorizeHttpRequests {
                it.requestMatchers("/deletePatient/**").hasRole("ADMIN")
                it.anyRequest().authenticated()

            }
            .exceptionHandling {
                it.accessDeniedPage("/notAutorized")
            }

            .build()
    }

}