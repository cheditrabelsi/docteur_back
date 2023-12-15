package com.chedi.docteur;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import com.chedi.docteur.contoller.UtilisateurController;
import com.chedi.docteur.entities.Utilisateur;
import com.chedi.docteur.services.UtilisateurService;

@WebMvcTest(UtilisateurController.class)
public class UtilisateurControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UtilisateurService utilisateurService;

    @MockBean
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void testLoginSuccess() throws Exception {
        Utilisateur mockUtilisateur = new Utilisateur();
        mockUtilisateur.setEmail("test@example.com");
        mockUtilisateur.setMdp(bCryptPasswordEncoder.encode("password")); 

        when(utilisateurService.getUtilisateur("testt@example.com")).thenReturn(Optional.of(mockUtilisateur));
        when(bCryptPasswordEncoder.matches("password", mockUtilisateur.getMdp())).thenReturn(true);

        String responseContent = mockMvc.perform(get("/utilisateur/login/test@example.com/password"))
        	    .andExpect(status().isOk())
        	    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        	    .andReturn().getResponse().getContentAsString();

        	System.out.println("Response Content: " + responseContent);

    }

}
