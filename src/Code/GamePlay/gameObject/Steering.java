package Code.GamePlay.gameObject;

import Code.GamePlay.math.Vector2f;

public class Steering {
    public Vector2f pos;

    public Steering(Vector2f pos){
        this.pos = pos;

    }

    public Vector2f getDirection(Vector2f point){
        return point.sub(pos.normailize());
    }

    public Vector2f getVel(Vector2f direction, float speed){
        return direction.scale(speed);
    }
}
