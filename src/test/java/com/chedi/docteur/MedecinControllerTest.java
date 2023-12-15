package com.chedi.docteur;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.chedi.docteur.contoller.MedecinController;
import com.chedi.docteur.entities.Medecin;
import com.chedi.docteur.entities.Utilisateur;
import com.chedi.docteur.services.MedecinService;
import com.chedi.docteur.services.UtilisateurService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(MedecinController.class)
public class MedecinControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedecinService medecinService;

    @MockBean
    private UtilisateurService utilisateurService;
    @MockBean
    private BCryptPasswordEncoder bCryptPasswordEncoder;

   // @Test
    public void testGetMedecin() throws Exception {
        Medecin mockMedecin = new Medecin();
        mockMedecin.setEmail("test@example.com");
        when(medecinService.getMedecin("test@example.com")).thenReturn(mockMedecin);

        String responseContent = mockMvc.perform(get("/medecin/getMedecin/test@example.com"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        System.out.println("Response Content: " + responseContent);
    }

   // @Test
    public void testGetAll() throws Exception {
        List<Medecin> mockMedecins = new ArrayList<>();
        Medecin medecin = new Medecin();
        medecin.setId(1);
        medecin.setNom("chedi");
        medecin.setPrenom("trabelsi");
        medecin.setEmail("chedi@gmail.com");
        medecin.setMdp("password");
        medecin.setTel("1252121");
        medecin.setRole("medecin");

        mockMedecins.add(medecin);
        when(medecinService.getAll()).thenReturn(mockMedecins);

        String responseContent = mockMvc.perform(get("/medecin/getAll"))
        	    .andExpect(status().isOk())
        	    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        	    .andReturn().getResponse().getContentAsString();

        	System.out.println("Response Content: " + responseContent);
    }

    @Test
    public void testAdd() throws Exception {
        Medecin medecin = new Medecin();
        medecin.setId(1);
       
        medecin.setEmail("test@example.com");
        

        when(utilisateurService.exist("test@example.com")).thenReturn(false);

        MvcResult result = mockMvc.perform(post("/medecin/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"id\": 1, \"email\": \"test@example.com\", \"mdp\": \"password\" }"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println("Response Content: " + result.getResponse().getContentAsString());
    }
    


}
