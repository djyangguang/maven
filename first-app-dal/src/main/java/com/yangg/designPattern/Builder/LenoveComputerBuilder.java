package com.yangg.designPattern.Builder;

public class LenoveComputerBuilder implements ComputerBuilder {
	private Computer lenoveComputer;
	public void LenoverComputerBuilder(){
		lenoveComputer = new Computer();
		
	}
	@Override
	public void buildCPU() {
		// TODO Auto-generated method stub
		lenoveComputer.setCpu( new InterCPU());
		
	}

	@Override
	public void buildMemory() {
		// TODO Auto-generated method stub
		lenoveComputer.setMemory( new KingstonMemory());
	}

	@Override
	public void buildMainboard() {
		// TODO Auto-generated method stub
		lenoveComputer.setMainboard(new AsusMainboard());
	}

	@Override
	public Computer getComputer() {
		// TODO Auto-generated method stub
		return lenoveComputer;
	}

}
