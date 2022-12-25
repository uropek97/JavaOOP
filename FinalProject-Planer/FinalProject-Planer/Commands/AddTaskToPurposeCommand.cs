using FinalProject_Planer.Commands.Base;

namespace FinalProject_Planer.Commands
{
    public class AddTaskToPurposeCommand : PlanerCommand
    {
        private IUserInterface? _UserInterface;
        private Presenter? _Presenter;

        public AddTaskToPurposeCommand(IUserInterface? userInterface, Presenter? presenter)
        {
            _UserInterface = userInterface;
            _Presenter = presenter;
        }

        public override string? Describe => "Добавить задачу цели.";

        public override void Execute(string[] args)
        {
            this._UserInterface!.printMessage("Цели: ", true);
            foreach(var purpose in this._Presenter!.Planer!.Purposes!)
                this._UserInterface!.printMessage(purpose.ToString(), true);

            string name = this._UserInterface!.getData("Добавить задачу цели: ");

            if (this._Presenter!.Planer!.Purposes!.Contains(new MyPurpose(name)))
            {
                var a = this._Presenter!.Planer!.Purposes!.Find(x => x.Name == name);
                a!.AddTask(this._UserInterface!.getData("Добавить задачу: "));
            }
        }
    }
}
