package BuilderUtils;
import Enumeration.RpnHDD;
import Enumeration.TypeHdd;

public interface Builder {

    void setCapacity(double capacity);

    void setPhysicalParameters(PhysicalParameters physicalParameters);


    void setManufactor(String manufactor);

    void setRpn(Enum<RpnHDD> rpn);

    void setSizeBuffer(Object sizeBuffer);

    void setType(Enum<TypeHdd> type);

    HardDrive getHDD();
}
