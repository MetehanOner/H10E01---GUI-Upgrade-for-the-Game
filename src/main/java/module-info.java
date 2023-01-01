module Game {
    requires org.checkerframework.checker.qual;
    requires javafx.controls;
    requires javafx.graphics;

    opens de.tum.in.ase to javafx.graphics, javafx.controls;
    opens de.tum.in.ase.logic to javafx.controls, javafx.graphics;

    exports de.tum.in.ase;
    exports de.tum.in.ase.logic;
}
