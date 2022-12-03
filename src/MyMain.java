public class MyMain {

	public static void main(String[] args) {

		// TASK 1: CREATE A CANVAS FOR ANIMATION
		Canvas canvas = new Canvas();
		canvas.requestFocus();
		
		//TASK 2:  ADD A USER GAME OBJECT
		Type_D_GameObject user = new Type_D_GameObject(400, 550);
		canvas.addKeyListener(user);
		canvas.addGameObject(user);

		canvas.addGameObject(new Type_A_GameObject(550, 50));
		canvas.addGameObject(new Type_C_GameObject(200, 350));
		canvas.addGameObject(new Type_B_GameObject(50, 150));

	}

}

