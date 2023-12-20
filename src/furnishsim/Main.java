package furnishsim;

public class Main
{
    public static void main(String[] args)
    {
        Business industrialBusiness = new Business();
        GuiManager guiManager = new GuiManager(industrialBusiness);
        guiManager.runSimulation();
    }
}
