package BuilderUtils;

import Enumeration.RpnHDD;
import Enumeration.TypeHdd;

public class BuilderHdd implements Builder {
    private double capacity;
    private PhysicalParameters physicalParameters;
    private String manufactor;
    private Enum<RpnHDD> rpm;
    private Object sizeBuffer;
    private Enum<TypeHdd> typeHdd;

    @Override
    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    @Override
    public void setPhysicalParameters(PhysicalParameters physicalParameters) {
        this.physicalParameters = physicalParameters;
    }

    @Override
    public void setManufactor(String manufactor) {
      int a=  Integer.valueOf(manufactor); //third exception NumberFormatException
        this.manufactor = manufactor;
    }

    @Override
    public void setRpn(Enum<RpnHDD> rpn) {
        this.rpm = rpn;
    }

    @Override
    public void setSizeBuffer(Object sizeBuffer) {

        this.sizeBuffer = (int)sizeBuffer;
    }

    @Override
    public void setType(Enum<TypeHdd> typeHdd) {
        this.typeHdd = typeHdd;
    }

    @Override
    public HardDrive getHDD() {
        return new HardDrive(capacity, physicalParameters, manufactor, rpm, (int)sizeBuffer, typeHdd);
    }

}
