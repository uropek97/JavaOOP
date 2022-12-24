namespace FinalProject_Planer
{
    public interface IMyFileHelper
    {
        public void Write(string data, string fileName);

        public string Read(string fileName);
    }
}
