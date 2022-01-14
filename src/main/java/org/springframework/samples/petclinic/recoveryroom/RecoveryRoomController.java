package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecoveryRoomController {
    
	private RecoveryRoomService recoveryRoomService;
	
	public RecoveryRoomController (RecoveryRoomService recoveryRoomService) {
		this.recoveryRoomService=recoveryRoomService;
	}
	
	
	@GetMapping(value="recoveryroom/create")
	public String initCreationForm(Map<String,Object> model) {
		RecoveryRoom recoveryRoom= new RecoveryRoom();
		
		
		model.put("recoveryRoom", recoveryRoom);
		
		
		return "recoveryroom/createOrUpdateRecoveryRoomForm";
	}
	
	@PostMapping("recoveryroom/create")
	public String proccessCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result) {
		if(result.hasErrors()) {
			return "recoveryroom/createOrUpdateRecoveryRoomForm";
		}else {
			this.recoveryRoomService.save(recoveryRoom);
			return "welcome";
		}
	}
}
