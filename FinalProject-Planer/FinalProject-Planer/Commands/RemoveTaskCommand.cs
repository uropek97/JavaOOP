using FinalProject_Planer.Commands.Base;

namespace FinalProject_Planer.Commands
{
    public class RemoveTaskCommand : PlanerCommand
    {
        private IUserInterface? _UserInterface;
        private Presenter? _Presenter;

        public RemoveTaskCommand(IUserInterface? userInterface, Presenter? presenter)
        {
            this._UserInterface = userInterface;
            this._Presenter = presenter;
        }

        public override string? Describe => "Удалить задачу.";

        public override void Execute(string[] args)
        {
            foreach (var task in this._Presenter!.Planer!.Tasks!)
                this._UserInterface!.printMessage(task.ToString(), true);


            this._Presenter.Planer.RemoveTask(this._UserInterface?.getData("Удалить задачу: ")!);
            this._Presenter.Save();
        }
    }
}
