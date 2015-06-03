package ql_obj_alg.check;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ql_obj_alg.check.errors.GenError;
import ql_obj_alg.check.warnings.Warning;

public class ErrorReporting {
	private List<GenError> errors;
	private Set<Warning> warnings;
	
	public ErrorReporting(){
		errors = new ArrayList<GenError>();
		warnings = new HashSet<Warning>();
	}
	public void addError(GenError error){
		errors.add(error);
	}
	
	public void addWarning(Warning warning){
		warnings.add(warning);
	}
	
	public void printErrors(){
		System.out.println("Errors: "+errors.size());
		for(GenError error : errors)
			System.out.println("Error: "+error.toString());
	}
	
	public void printWarnings(){
		System.out.println("Warnings: "+warnings.size());
		for(Warning warning : warnings)
			System.out.println("Warning: "+warning.toString());
	}
	
	public int numberOfErrors(){
		return errors.size();
	}
	
	public int numberOfWarnings(){
		return warnings.size();
	}
	
	public boolean containsError(GenError error){
		return errors.contains(error);
	}
	
	public boolean containsWarning(Warning warning){
		return warnings.contains(warning);
	}
}
