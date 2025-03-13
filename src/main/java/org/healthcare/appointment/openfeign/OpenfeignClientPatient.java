package org.healthcare.appointment.openfeign;

import org.healthcare.patient.dto.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="${app.patient.url}",name="ps")
public interface OpenfeignClientPatient {

	@GetMapping("/{id}")
	public Patient findById(@PathVariable int id);
}
