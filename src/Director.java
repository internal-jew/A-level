import BuilderUtils.BuilderHdd;
import BuilderUtils.PhysicalParameters;
import Enumeration.RpnHDD;
import Enumeration.TypeHdd;

class Director {
    public void makeInternalHddForDesktop(BuilderHdd builderHdd) {
        builderHdd.setCapacity(4000);
        builderHdd.setPhysicalParameters(new PhysicalParameters(20.0, 10.0, 2.0));
        builderHdd.setManufactor("Baracuda");
        builderHdd.setRpn(RpnHDD.RPN_HDD_7200);
        builderHdd.setSizeBuffer("wew"); // first exception ClassCastException
        // builderHdd.setSizeBuffer(64);
        builderHdd.setType(TypeHdd.INTERNAL_DESKTOP);
    }

    public void makeExternalHddForDesktop(BuilderHdd builderHdd) {
        builderHdd.setCapacity(4000);
        builderHdd.setPhysicalParameters(new PhysicalParameters(10.0, 5.0, 1.0));
        builderHdd.setManufactor("Baracuda");
        builderHdd.setRpn(RpnHDD.RPN_HDD_7200);
        //  builderHdd.setSizeBuffer(64); //second exception NullPointerException
        builderHdd.setType(TypeHdd.EXTERNAL);
    }

    public void makeInternalHddForNotebook(BuilderHdd builderHdd) {
        builderHdd.setCapacity(4000);
        builderHdd.setPhysicalParameters(new PhysicalParameters(5.0, 5.0, 1.0));
        builderHdd.setManufactor("Baracuda");
        builderHdd.setRpn(RpnHDD.RPN_HDD_5200);
        builderHdd.setSizeBuffer(32);
        builderHdd.setType(TypeHdd.INTERNAL_NOTEBOOK);
    }

}
