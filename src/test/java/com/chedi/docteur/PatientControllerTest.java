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
import com.chedi.docteur.contoller.PatientController;
import com.chedi.docteur.entities.Medecin;
import com.chedi.docteur.entities.Patient;
import com.chedi.docteur.entities.Utilisateur;
import com.chedi.docteur.services.MedecinService;
import com.chedi.docteur.services.PatientService;
import com.chedi.docteur.services.UtilisateurService;

@WebMvcTest(PatientController.class)
public class PatientControllerTest {
	 @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private PatientService patientService;

	    @MockBean
	    private UtilisateurService utilisateurService;
	    @MockBean
	    private BCryptPasswordEncoder bCryptPasswordEncoder;

	  // @Test
	    public void testGetPatient() throws Exception {
	        Patient mockPatient = new Patient();
	        mockPatient.setEmail("test@example.com");
	        when(patientService.getPatient("test@example.com")).thenReturn(mockPatient);

	        String responseContent = mockMvc.perform(get("/patient/getPatient/test@example.com"))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	                .andReturn().getResponse().getContentAsString();

	        System.out.println("Response Content: " + responseContent);
	    }
	   @Test
	    public void testAdd() throws Exception {
	        Patient patient = new Patient();
	        patient.setId(1);
	        patient.setNom("chedi");
	        patient.setPrenom("trabelsi");
	        patient.setEmail("test@example.com");
	        patient.setMdp("password");
	        patient.setTel("1252121");
	        patient.setRole("patient");
	        when(utilisateurService.exist("test@example.com")).thenReturn(false);

	        MvcResult result = mockMvc.perform(post("/patient/add")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content("{ \"id\": 1, \"email\": \"test@example.com\", \"mdp\": \"password\" }"))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	                .andReturn();

	        System.out.println("Response Content: " + result.getResponse().getContentAsString());
	    }


}
