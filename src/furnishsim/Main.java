package furnishsim;

public class Main
{
    public static void main(String[] args)
    {
        Business industrialBusiness = new Business();
        System.out.println(industrialBusiness);

        GuiManager guiManager = new GuiManager(industrialBusiness);
        guiManager.runSimulation();
    }
}
