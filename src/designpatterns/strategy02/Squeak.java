package designpatterns.strategy02;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/12 8:55
 */
public class Squeak implements DuckBehavior {
    @Override
    public void behavior() {
        System.out.println("吱吱吱吱吱!!!");
    }
}
