package BuilderUtils;

import Enumeration.RpnHDD;
import Enumeration.TypeHdd;

public class HardDrive {
    private final double capacity;
    private final PhysicalParameters physicalParameters;
    private final String manufactor;
    private final Enum<RpnHDD> rpm;
    private final int sizeBuffer;
    private final Enum<TypeHdd> typeHdd;

    double getCapacity() {
        return capacity;
    }

    PhysicalParameters getPhysicalParameters() {
        return physicalParameters;
    }

    String getManufactor() {
        return manufactor;
    }

    Enum<RpnHDD> getRpm() {
        return rpm;
    }

    int getSizeBuffer() {
        return sizeBuffer;
    }

    Enum<TypeHdd> getTypeHdd() {
        return typeHdd;
    }

    HardDrive(double capacity, PhysicalParameters physicalParameters, String manufactor, Enum<RpnHDD> rpm, int sizeBuffer, Enum<TypeHdd> typeHdd) {
        this.capacity = capacity;
        this.physicalParameters = physicalParameters;
        this.manufactor = manufactor;
        this.rpm = rpm;
        this.sizeBuffer = sizeBuffer;
        this.typeHdd = typeHdd;
    }

    @Override
    public String toString() {
        return "HardDrive{" +
                "capacity=" + capacity +
                ", physicalParameters=" + physicalParameters +
                ", manufactor='" + manufactor + '\'' +
                ", rpm=" + rpm +
                ", sizeBuffer=" + sizeBuffer +
                ", typeHdd=" + typeHdd +
                '}';
    }
}
