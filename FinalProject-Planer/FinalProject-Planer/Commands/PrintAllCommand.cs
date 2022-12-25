using FinalProject_Planer.Commands.Base;

namespace FinalProject_Planer.Commands
{
    public class PrintAllCommand : PlanerCommand
    {
        private IUserInterface _UserInterface;
        private Presenter? _Presenter;

        public PrintAllCommand(IUserInterface userInterface, Presenter? presenter)
        {
            _UserInterface = userInterface;
            _Presenter = presenter;
        }

        public override string? Describe => "Показывает все цели и задачи";

        public override void Execute(string[] args)
        {
            this._UserInterface.printMessage("Цели: ", true);
            foreach (var purpose in this._Presenter!.Planer!.Purposes!)
            {
                this._UserInterface.printMessage(purpose.ToString(), true);
            }
            this._UserInterface.printMessage("Задачи: ", true);
            foreach (var purpose in this._Presenter!.Planer!.Tasks!)
            {
                this._UserInterface.printMessage(purpose.ToString(), true);
            }
        }
    }
}
