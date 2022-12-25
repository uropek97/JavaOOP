using FinalProject_Planer.Commands.Base;

namespace FinalProject_Planer.Commands
{
    public class RemovePurposeCommand : PlanerCommand
    {
        private IUserInterface? _UserInterface;
        private Presenter? _Presenter;

        public RemovePurposeCommand(IUserInterface? userInterface, Presenter? presenter)
        {
            this._UserInterface = userInterface;
            this._Presenter = presenter;
        }

        public override string? Describe => "Удалить задачу.";

        public override void Execute(string[] args)
        {
            foreach (var purpuse in this._Presenter!.Planer!.Purposes!)
                this._UserInterface!.printMessage(purpuse.ToString(), true);


            this._Presenter.Planer.RemovePurpuse(this._UserInterface?.getData("Удалить задачу: ")!);
            this._Presenter.Save();
        }
    }
}
