namespace FinalProject_Planer
{
    public class Presenter
    {
        private Planer? _Planer;
        private IUserInterface? _UserInterface;
        private IMyFileHelper? _FileHelper;

        public Planer? Planer { get { return _Planer; } set { _Planer = value; } }
        public IUserInterface? UserInterface { get { return _UserInterface; } set { _UserInterface = value; } }
        public IMyFileHelper? FileHelper { get { return _FileHelper; } set { _FileHelper = value; } }

        public Presenter(IUserInterface? userInteface, IMyFileHelper fileHelper)
        {
            this.UserInterface = userInteface;
            this.FileHelper = fileHelper;
            this.Planer = this.FileHelper.Read();
        }

        public void Work()
        {

        }
    }
}
