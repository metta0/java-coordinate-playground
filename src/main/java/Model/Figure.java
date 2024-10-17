package Model;

abstract class Figure {
    Points points;

    abstract void validationFigure(Points points);

    public abstract double getArea();
}
