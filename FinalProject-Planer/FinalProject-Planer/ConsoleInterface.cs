namespace FinalProject_Planer
{
    public class ConsoleInterface : IUserInterface
    {
        public string getData(string message)
        {
            printMessage(message, false);
            return Console.ReadLine()!;
        }

        public void printMessage(string message, bool ifNew)
        {
            if (ifNew)
                Console.WriteLine(message);
            else
                Console.Write(message);
        }
    }
}
