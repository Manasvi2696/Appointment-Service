package org.healthcare.appointment.openfeign;

import org.healthcare.doctor.dto.Doctor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="${app.doctor.url}",name="ds")
public interface OpenfeignClientDoctor {

	@GetMapping("/{id}")
	public Doctor getById(@PathVariable int id);
}
