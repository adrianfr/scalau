/*
 * DO NOT MODIFY THIS FILE. It is code-generated from config/UnitsDef_Imperial.txt
 */
package scalau.units

import scalau._

object Units_Imperial {

	class Length(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = Length
		def build(x:Double) = new Length(x)
		val baseUnits = "_m"
		val mainUnit = "_m"
		val allUnits = Map[String, Double]("_m" -> 1.0, "_mi" -> 1609.344, "_ft" -> 0.3048, "_in" -> 0.0254)
		def _m = new Length(x * 1.0)
		def _mi = new Length(x * 1609.344)
		def _ft = new Length(x * 0.3048)
		def _in = new Length(x * 0.0254)
	}

	class Mass(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = Mass
		def build(x:Double) = new Mass(x)
		val baseUnits = "_kg"
		val mainUnit = "_kg"
		val allUnits = Map[String, Double]("_kg" -> 1.0, "lb" -> 0.45359237)
		def _kg = new Mass(x * 1.0)
		def lb = new Mass(x * 0.45359237)
	}

	class Time(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = Time
		def build(x:Double) = new Time(x)
		val baseUnits = "_s"
		val mainUnit = "_s"
		val allUnits = Map[String, Double]("_second" -> 1.0, "_s" -> 1.0, "_hour" -> 3600.0, "_sec" -> 1.0, "_min" -> 60.0)
		def _second = new Time(x * 1.0)
		def _s = new Time(x * 1.0)
		def _hour = new Time(x * 3600.0)
		def _sec = new Time(x * 1.0)
		def _min = new Time(x * 60.0)
	}

	class ElectricCurrent(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = ElectricCurrent
		def build(x:Double) = new ElectricCurrent(x)
		val baseUnits = "_A"
		val mainUnit = "_A"
		val allUnits = Map[String, Double]("_A" -> 1.0)
		def _A = new ElectricCurrent(x * 1.0)
	}

	class Frequency(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = Frequency
		def build(x:Double) = new Frequency(x)
		val baseUnits = "__s"
		val mainUnit = "_Hz"
		val allUnits = Map[String, Double]("_Hz" -> 1.0)
		def _Hz = new Frequency(x * 1.0)
	}

	class Angle(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = Angle
		def build(x:Double) = new Angle(x)
		val baseUnits = "_rad"
		val mainUnit = "_rad"
		val allUnits = Map[String, Double]("_rad" -> 1.0, "_degree" -> 0.017453292519943295)
		def _rad = new Angle(x * 1.0)
		def _degree = new Angle(x * 0.017453292519943295)
	}

	class SolidAngle(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = SolidAngle
		def build(x:Double) = new SolidAngle(x)
		val baseUnits = "_sr"
		val mainUnit = "_sr"
		val allUnits = Map[String, Double]("_sr" -> 1.0)
		def _sr = new SolidAngle(x * 1.0)
	}

	class Force(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = Force
		def build(x:Double) = new Force(x)
		val baseUnits = "_kg_m__s2"
		val mainUnit = "_N"
		val allUnits = Map[String, Double]("_N" -> 1.0)
		def _N = new Force(x * 1.0)
	}

	class Pressure(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = Pressure
		def build(x:Double) = new Pressure(x)
		val baseUnits = "_kg__m__s2"
		val mainUnit = "_Pa"
		val allUnits = Map[String, Double]("_Pa" -> 1.0, "_N__m2" -> 1.0, "_kPa" -> 1000.0)
		def _Pa = new Pressure(x * 1.0)
		def _N__m2 = new Pressure(x * 1.0)
		def _kPa = new Pressure(x * 1000.0)
	}

	class Energy(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = Energy
		def build(x:Double) = new Energy(x)
		val baseUnits = "_kg_m2__s2"
		val mainUnit = "_J"
		val allUnits = Map[String, Double]("_N_m" -> 1.0, "_C_V" -> 1.0, "_J" -> 1.0, "_kWh" -> 3600000.0, "_W_s" -> 1.0)
		def _N_m = new Energy(x * 1.0)
		def _C_V = new Energy(x * 1.0)
		def _J = new Energy(x * 1.0)
		def _kWh = new Energy(x * 3600000.0)
		def _W_s = new Energy(x * 1.0)
	}

	class Power(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = Power
		def build(x:Double) = new Power(x)
		val baseUnits = "_kg_m2__s3"
		val mainUnit = "_W"
		val allUnits = Map[String, Double]("_kW" -> 1000.0, "_hp" -> 745.699872, "_W" -> 1.0, "_J__s" -> 1.0, "_V_A" -> 1.0)
		def _kW = new Power(x * 1000.0)
		def _hp = new Power(x * 745.699872)
		def _W = new Power(x * 1.0)
		def _J__s = new Power(x * 1.0)
		def _V_A = new Power(x * 1.0)
	}

	class ElectricCharge(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = ElectricCharge
		def build(x:Double) = new ElectricCharge(x)
		val baseUnits = "_s_A"
		val mainUnit = "_C"
		val allUnits = Map[String, Double]("_C" -> 1.0)
		def _C = new ElectricCharge(x * 1.0)
	}

	class Voltage(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = Voltage
		def build(x:Double) = new Voltage(x)
		val baseUnits = "_kg_m2__s3__A"
		val mainUnit = "_V"
		val allUnits = Map[String, Double]("_V" -> 1.0, "_W__A" -> 1.0, "_J__C" -> 1.0)
		def _V = new Voltage(x * 1.0)
		def _W__A = new Voltage(x * 1.0)
		def _J__C = new Voltage(x * 1.0)
	}

	class Capacitance(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = Capacitance
		def build(x:Double) = new Capacitance(x)
		val baseUnits = "__kg__m2_s4_A2"
		val mainUnit = "_F"
		val allUnits = Map[String, Double]("_F" -> 1.0, "_C__V" -> 1.0)
		def _F = new Capacitance(x * 1.0)
		def _C__V = new Capacitance(x * 1.0)
	}

	class Resistance(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = Resistance
		def build(x:Double) = new Resistance(x)
		val baseUnits = "_kg_m2__s3__A2"
		val mainUnit = "_ohm"
		val allUnits = Map[String, Double]("_ohm" -> 1.0, "_V__A" -> 1.0)
		def _ohm = new Resistance(x * 1.0)
		def _V__A = new Resistance(x * 1.0)
	}

	class Conductance(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = Conductance
		def build(x:Double) = new Conductance(x)
		val baseUnits = "__kg__m2_s3_A2"
		val mainUnit = "_S"
		val allUnits = Map[String, Double]("_S" -> 1.0, "__ohm" -> 1.0, "_A__V" -> 1.0)
		def _S = new Conductance(x * 1.0)
		def __ohm = new Conductance(x * 1.0)
		def _A__V = new Conductance(x * 1.0)
	}

	class MagneticFlux(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = MagneticFlux
		def build(x:Double) = new MagneticFlux(x)
		val baseUnits = "_kg_m2__s2__A"
		val mainUnit = "_Wb"
		val allUnits = Map[String, Double]("_Wb" -> 1.0, "_J__A" -> 1.0)
		def _Wb = new MagneticFlux(x * 1.0)
		def _J__A = new MagneticFlux(x * 1.0)
	}

	class MagneticFluxDensity(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = MagneticFluxDensity
		def build(x:Double) = new MagneticFluxDensity(x)
		val baseUnits = "_kg__s2__A"
		val mainUnit = "_T"
		val allUnits = Map[String, Double]("_T" -> 1.0)
		def _T = new MagneticFluxDensity(x * 1.0)
	}

	class Inductance(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = Inductance
		def build(x:Double) = new Inductance(x)
		val baseUnits = "_kg_m2__s2__A2"
		val mainUnit = "_H"
		val allUnits = Map[String, Double]("_H" -> 1.0)
		def _H = new Inductance(x * 1.0)
	}

	class Radioactivity(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = Radioactivity
		def build(x:Double) = new Radioactivity(x)
		val baseUnits = "__s"
		val mainUnit = "_Bq"
		val allUnits = Map[String, Double]("_Bq" -> 1.0)
		def _Bq = new Radioactivity(x * 1.0)
	}

	class AbsorbedDose(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = AbsorbedDose
		def build(x:Double) = new AbsorbedDose(x)
		val baseUnits = "_m2__s2"
		val mainUnit = "_Gy"
		val allUnits = Map[String, Double]("_Gy" -> 1.0, "_J__kg" -> 1.0)
		def _Gy = new AbsorbedDose(x * 1.0)
		def _J__kg = new AbsorbedDose(x * 1.0)
	}

	class EquivalentDose(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = EquivalentDose
		def build(x:Double) = new EquivalentDose(x)
		val baseUnits = "_m2__s2"
		val mainUnit = "_Sv"
		val allUnits = Map[String, Double]("_Sv" -> 1.0, "_J__kg" -> 1.0)
		def _Sv = new EquivalentDose(x * 1.0)
		def _J__kg = new EquivalentDose(x * 1.0)
	}

	class Area(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = Area
		def build(x:Double) = new Area(x)
		val baseUnits = "_m2"
		val mainUnit = "_m2"
		val allUnits = Map[String, Double]("_m2" -> 1.0, "_acre" -> 4046.85642)
		def _m2 = new Area(x * 1.0)
		def _acre = new Area(x * 4046.85642)
	}

	class Volume(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = Volume
		def build(x:Double) = new Volume(x)
		val baseUnits = "_m3"
		val mainUnit = "_m3"
		val allUnits = Map[String, Double]("_m3" -> 1.0, "_gallon" -> 0.00378541)
		def _m3 = new Volume(x * 1.0)
		def _gallon = new Volume(x * 0.00378541)
	}

	class Speed(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = Speed
		def build(x:Double) = new Speed(x)
		val baseUnits = "_m__s"
		val mainUnit = "_m__s"
		val allUnits = Map[String, Double]("_m__s" -> 1.0, "_km__hour" -> 3.6, "_km__h" -> 3.6)
		def _m__s = new Speed(x * 1.0)
		def _km__hour = new Speed(x * 3.6)
		def _km__h = new Speed(x * 3.6)
	}

	class Acceleration(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = Acceleration
		def build(x:Double) = new Acceleration(x)
		val baseUnits = "_m__s2"
		val mainUnit = "_m__s2"
		val allUnits = Map[String, Double]("_m__s2" -> 1.0)
		def _m__s2 = new Acceleration(x * 1.0)
	}

	class SpeedSquared(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
		type Impl = SpeedSquared
		def build(x:Double) = new SpeedSquared(x)
		val baseUnits = "_m2__s2"
		val mainUnit = "_m2__s2"
		val allUnits = Map[String, Double]("_m2__s2" -> 1.0)
		def _m2__s2 = new SpeedSquared(x * 1.0)
	}

	// implicit conversions: Double to <Dimension>

	implicit def doubleToLength(x: Double) = new Length(x)
	implicit def doubleToMass(x: Double) = new Mass(x)
	implicit def doubleToTime(x: Double) = new Time(x)
	implicit def doubleToElectricCurrent(x: Double) = new ElectricCurrent(x)
	implicit def doubleToFrequency(x: Double) = new Frequency(x)
	implicit def doubleToAngle(x: Double) = new Angle(x)
	implicit def doubleToSolidAngle(x: Double) = new SolidAngle(x)
	implicit def doubleToForce(x: Double) = new Force(x)
	implicit def doubleToPressure(x: Double) = new Pressure(x)
	implicit def doubleToEnergy(x: Double) = new Energy(x)
	implicit def doubleToPower(x: Double) = new Power(x)
	implicit def doubleToElectricCharge(x: Double) = new ElectricCharge(x)
	implicit def doubleToVoltage(x: Double) = new Voltage(x)
	implicit def doubleToCapacitance(x: Double) = new Capacitance(x)
	implicit def doubleToResistance(x: Double) = new Resistance(x)
	implicit def doubleToConductance(x: Double) = new Conductance(x)
	implicit def doubleToMagneticFlux(x: Double) = new MagneticFlux(x)
	implicit def doubleToMagneticFluxDensity(x: Double) = new MagneticFluxDensity(x)
	implicit def doubleToInductance(x: Double) = new Inductance(x)
	implicit def doubleToRadioactivity(x: Double) = new Radioactivity(x)
	implicit def doubleToAbsorbedDose(x: Double) = new AbsorbedDose(x)
	implicit def doubleToEquivalentDose(x: Double) = new EquivalentDose(x)
	implicit def doubleToArea(x: Double) = new Area(x)
	implicit def doubleToVolume(x: Double) = new Volume(x)
	implicit def doubleToSpeed(x: Double) = new Speed(x)
	implicit def doubleToAcceleration(x: Double) = new Acceleration(x)
	implicit def doubleToSpeedSquared(x: Double) = new SpeedSquared(x)



	// Implicits for Dimensional Operations

	implicit def Length_x_Length(a:Length, b:Length) = new Area(a.x * b.x)
	implicit def Area_d_Length(a:Area, b:Length, op:Null) = new Length(a.x / b.x)
	implicit def sqroot(a: Area, op:Null) = new Length(scala.math.sqrt(a.x))

	implicit def Area_x_Length(a:Area, b:Length) = new Volume(a.x * b.x)
	implicit def Length_x_Area(a:Length, b:Area) = new Volume(a.x * b.x)
	implicit def Volume_d_Area(a:Volume, b:Area, op:Null) = new Length(a.x / b.x)
	implicit def Volume_d_Length(a:Volume, b:Length, op:Null) = new Area(a.x / b.x)

	implicit def Speed_x_Time(a:Speed, b:Time) = new Length(a.x * b.x)
	implicit def Time_x_Speed(a:Time, b:Speed) = new Length(a.x * b.x)
	implicit def Length_d_Speed(a:Length, b:Speed, op:Null) = new Time(a.x / b.x)
	implicit def Length_d_Time(a:Length, b:Time, op:Null) = new Speed(a.x / b.x)

	implicit def Acceleration_x_Time(a:Acceleration, b:Time) = new Speed(a.x * b.x)
	implicit def Time_x_Acceleration(a:Time, b:Acceleration) = new Speed(a.x * b.x)
	implicit def Speed_d_Acceleration(a:Speed, b:Acceleration, op:Null) = new Time(a.x / b.x)
	implicit def Speed_d_Time(a:Speed, b:Time, op:Null) = new Acceleration(a.x / b.x)

	implicit def Speed_x_Speed(a:Speed, b:Speed) = new SpeedSquared(a.x * b.x)
	implicit def SpeedSquared_d_Speed(a:SpeedSquared, b:Speed, op:Null) = new Speed(a.x / b.x)
	implicit def sqroot(a: SpeedSquared, op:Null) = new Speed(scala.math.sqrt(a.x))

	implicit def Mass_x_Acceleration(a:Mass, b:Acceleration) = new Force(a.x * b.x)
	implicit def Acceleration_x_Mass(a:Acceleration, b:Mass) = new Force(a.x * b.x)
	implicit def Force_d_Mass(a:Force, b:Mass, op:Null) = new Acceleration(a.x / b.x)
	implicit def Force_d_Acceleration(a:Force, b:Acceleration, op:Null) = new Mass(a.x / b.x)

	implicit def Force_x_Speed(a:Force, b:Speed) = new Power(a.x * b.x)
	implicit def Speed_x_Force(a:Speed, b:Force) = new Power(a.x * b.x)
	implicit def Power_d_Force(a:Power, b:Force, op:Null) = new Speed(a.x / b.x)
	implicit def Power_d_Speed(a:Power, b:Speed, op:Null) = new Force(a.x / b.x)

	implicit def Voltage_x_ElectricCurrent(a:Voltage, b:ElectricCurrent) = new Power(a.x * b.x)
	implicit def ElectricCurrent_x_Voltage(a:ElectricCurrent, b:Voltage) = new Power(a.x * b.x)
	implicit def Power_d_Voltage(a:Power, b:Voltage, op:Null) = new ElectricCurrent(a.x / b.x)
	implicit def Power_d_ElectricCurrent(a:Power, b:ElectricCurrent, op:Null) = new Voltage(a.x / b.x)

	implicit def ElectricCurrent_x_Resistance(a:ElectricCurrent, b:Resistance) = new Voltage(a.x * b.x)
	implicit def Resistance_x_ElectricCurrent(a:Resistance, b:ElectricCurrent) = new Voltage(a.x * b.x)
	implicit def Voltage_d_ElectricCurrent(a:Voltage, b:ElectricCurrent, op:Null) = new Resistance(a.x / b.x)
	implicit def Voltage_d_Resistance(a:Voltage, b:Resistance, op:Null) = new ElectricCurrent(a.x / b.x)

	implicit def Power_x_Time(a:Power, b:Time) = new Energy(a.x * b.x)
	implicit def Time_x_Power(a:Time, b:Power) = new Energy(a.x * b.x)
	implicit def Energy_d_Power(a:Energy, b:Power, op:Null) = new Time(a.x / b.x)
	implicit def Energy_d_Time(a:Energy, b:Time, op:Null) = new Power(a.x / b.x)

	implicit def Mass_x_SpeedSquared(a:Mass, b:SpeedSquared) = new Energy(a.x * b.x)
	implicit def SpeedSquared_x_Mass(a:SpeedSquared, b:Mass) = new Energy(a.x * b.x)
	implicit def Energy_d_Mass(a:Energy, b:Mass, op:Null) = new SpeedSquared(a.x / b.x)
	implicit def Energy_d_SpeedSquared(a:Energy, b:SpeedSquared, op:Null) = new Mass(a.x / b.x)

}

