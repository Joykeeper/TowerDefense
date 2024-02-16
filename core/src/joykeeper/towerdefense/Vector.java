package joykeeper.towerdefense;

import java.util.Map;

public class Vector {
    public static Vector ZERO = new Vector(0f, 0f);

    public final float x;
    public final float y;
    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector(float angle) {
        this.x = (float) Math.cos(angle);
        this.y = (float) Math.sin(angle);
    }

    public Vector add(Vector b) {
        return new Vector(x + b.x, y + b.y);
    }

    public Vector sub(Vector b) {
        return new Vector(x - b.x, y - b.y);
    }

    public Vector mul(float b) {
        return new Vector(x * b, y * b);
    }

    public Vector normalized() {
        float len = length();
        if (len < 0.001) return Vector.ZERO;
        return this.mul(1.0f / len);
    }

    public float length() {
        return (float) Math.sqrt(this.length2());
    }

    public float length2() {
        return x*x + y*y;
    }
}
