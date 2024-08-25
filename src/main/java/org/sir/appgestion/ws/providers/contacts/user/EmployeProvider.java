package org.sir.appgestionstock.ws.providers.contacts.user;
import org.sir.appgestionstock.service.facade.contacts.user.EmployeService;
import org.sir.appgestionstock.ws.converter.contacts.user.EmployeConverter;
import org.sir.appgestionstock.ws.dto.contacts.user.EmployeDto;
import org.sir.appgestionstock.zutils.code.CodeGenerator;
import org.sir.appgestionstock.zutils.code.CodeResponse;
import org.sir.appgestionstock.zutils.pagination.Pagination;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/employe")
public class EmployeProvider {
@Autowired private EmployeService service;
@Autowired private EmployeConverter converter;

    @GetMapping("/{username}")
    public ResponseEntity<EmployeDto> findByUsername(@PathVariable String username) {
        var result = service.findByUsername(username);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<EmployeDto> findById(@PathVariable Long id) {
    var result = service.findById(id);
    var resultDto = converter.toDto(result);
    return ResponseEntity.ok(resultDto);
    }
    @GetMapping
    public ResponseEntity<List<EmployeDto>> findAll() {
    var result = service.findAll();
    var resultDto = converter.toDto(result);
    return ResponseEntity.ok(resultDto);
    }
    @GetMapping("/optimized")
    public ResponseEntity<List<EmployeDto>> findAllOptimized() {
    var result = service.findAllOptimized();
    var resultDto = converter.toDto(result);
    return ResponseEntity.ok(resultDto);
    }
    @GetMapping("/paginated")
    public ResponseEntity<Pagination<EmployeDto>> findPaginated(
    @RequestParam(name = "page", defaultValue = "0", required = false) int page,
    @RequestParam(name = "size", defaultValue = "10", required = false) int size
    ) {
    var result = service.findPaginated(page, size);
    var pagination = result.convert(converter::toDto);
    return ResponseEntity.ok(pagination);
    }
@PostMapping
public ResponseEntity<EmployeDto> save(@RequestBody EmployeDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping("/all")
public ResponseEntity<List<EmployeDto>> save(@RequestBody List<EmployeDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping()
public ResponseEntity<EmployeDto> update(@RequestBody EmployeDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping("/all")
public ResponseEntity<List<EmployeDto>> update(@RequestBody List<EmployeDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping
public ResponseEntity<EmployeDto> delete(@RequestBody EmployeDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
service.delete(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<EmployeDto>> delete(@RequestBody List<EmployeDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
service.delete(item);
return ResponseEntity.ok(dtos);
}
@DeleteMapping("/id/{id}")
public ResponseEntity<Long> deleteById(@PathVariable Long id) {
service.deleteById(id);
return ResponseEntity.ok(id);
}
@DeleteMapping("/ids")
public ResponseEntity<List<Long>> deleteByIdIn(@RequestParam("id") List<Long> ids) {
service.deleteByIdIn(ids);
return ResponseEntity.ok(ids);
}
@DeleteMapping("/adresse/id/{id}")
public ResponseEntity<Long> deleteByAdresseId(@PathVariable Long id){
service.deleteByAdresseId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/adresse/id/{id}")
public ResponseEntity<EmployeDto> findByAdresseId(@PathVariable Long id){
var result = service.findByAdresseId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping("/entreprise/id/{id}")
public ResponseEntity<Long> deleteByEntrepriseId(@PathVariable Long id){
service.deleteByEntrepriseId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/entreprise/id/{id}")
public ResponseEntity<List<EmployeDto>> findByEntrepriseId(@PathVariable Long id){
var result = service.findByEntrepriseId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
    @GetMapping("/next-code")
    public ResponseEntity<CodeResponse> getNextCode() {
        var generated = CodeGenerator.generate("E", service.findMaxId());
        return ResponseEntity.ok(generated);
    }

    @GetMapping("/admin/{admin}")
    public ResponseEntity<List<EmployeDto>> findByAdmin(@PathVariable String admin){
        var result = service.findByAdmin(admin);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

}