package com.oops.scenariobased;

interface IControllable{
	void turnOn();
	void turnOff();
	void reset();
}

class Device{
	private String deviceId;
	private boolean status;
	protected double energyUsage;
	
	public Device(String deviceId,double energyUsage) {
		this.deviceId=deviceId;
		this.status=false;
		this.energyUsage=energyUsage;
		System.out.println("Device registered : "+ deviceId);
	}
	public boolean isOn() {
		return status;
	}
	protected void setStatus(boolean status) {
		this.status=status;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public double calculateEnergy(int hours) {
		return energyUsage*hours;
	}
	public void turnOn() {
		setStatus(true);
		System.out.println(deviceId + " turned ON");
	}
	public void turnOff() {
		setStatus(false);
		System.out.println(deviceId + "turned OFF");
	}
}
class Light extends Device{
	public Light(String deviceId) {
		super(deviceId,0.5);
	}
	public void reset() {
		System.out.println("light reset");
	}
}
class Camera extends Device{
	public Camera(String deviceId) {
		super(deviceId,1.5);
	}
	public void reset() {
		System.out.println("camera reset ");
	}
}
class Thermostat extends Device{
	public Thermostat(String deviceId) {
		super(deviceId,1);
	}
	public void reset() {
		System.out.println("thermostat reset ");
	}
}
class Lock extends Device{
	public Lock(String deviceId) {
		super(deviceId,2);
	}
	public void reset() {
		System.out.println("lock reset");
	}
}

public class HomeNest {
	public static void main(String[] args) {
		Device light=new Light("Light-10");
		Device camera=new Camera("camera-101");
		Device thermostat=new Thermostat("thermostat-200");
		Device lock=new Lock("Lock-111");
		
		light.turnOn();
		camera.turnOn();
		thermostat.turnOn();
		lock.turnOn();
		
		System.out.println("Energy used by Thermostat (5 hrs): "+ thermostat.calculateEnergy(5) + " units");
                 
		
		light.reset();
		camera.reset();
		thermostat.reset();
		lock.reset();
		
		light.turnOff();
		camera.turnOff();
	}

}
