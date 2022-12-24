namespace FinalProject_Planer
{
    public interface IUserInterface
    {
        public void printMessage(string message, bool ifNew);//ifNew - с новой строки, или в отдельном окне
        public string getData(string message);
    }
}
