package com.chedi.docteur;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.chedi.docteur.contoller.PatientController;
import com.chedi.docteur.contoller.RendezvousController;
import com.chedi.docteur.entities.Medecin;
import com.chedi.docteur.entities.Patient;
import com.chedi.docteur.entities.Rendezvous;
import com.chedi.docteur.entities.Utilisateur;
import com.chedi.docteur.services.MedecinService;
import com.chedi.docteur.services.PatientService;
import com.chedi.docteur.services.RendezvousService;
import com.chedi.docteur.services.UtilisateurService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(RendezvousController.class)
public class RendezvousControllerTest {

	@Autowired
    private MockMvc mockMvc;
    @MockBean
    private RendezvousService rendezvousService;

    @MockBean
    private UtilisateurService utilisateurService;

   // @Test
    public void testGetRendezvous() throws Exception {
    	int medecinId = 1; 

        List<Rendezvous> mockRendezvousList = new ArrayList<>();
        mockRendezvousList.add(new Rendezvous());

        when(rendezvousService.getBymededin(medecinId)).thenReturn(mockRendezvousList);

     
        MvcResult result = mockMvc.perform(get("/rendezvous/getAllRendezvous/{id}", medecinId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        System.out.print((responseContent));
    }

    @Test
    public void testAddRendezvous() throws Exception {
    	 Rendezvous rendezvousToSave = new Rendezvous();
         doNothing().when(rendezvousService).save(rendezvousToSave);
         mockMvc.perform(post("/rendezvous/add")
                 .contentType(MediaType.APPLICATION_JSON)
                 .content(asJsonString(rendezvousToSave))) 
                 .andExpect(status().isOk())
                 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                 .andExpect(jsonPath("$.message").value("rendezvous saved"));
 
   }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
