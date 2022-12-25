using FinalProject_Planer.Commands.Base;

namespace FinalProject_Planer.Commands
{
    internal class GetPurouseFullinfoCommand : PlanerCommand
    {
        private IUserInterface? _UserInterface;
        private Presenter? _Presenter;

        public GetPurouseFullinfoCommand(IUserInterface? userInterface, Presenter? presenter)
        {
            this._UserInterface = userInterface;
            this._Presenter = presenter;
        }

        public override string? Describe => "Выдаёт полную информацию о цели.";

        public override void Execute(string[] args)
        {
            foreach (var item in this._Presenter!.Planer!.Purposes!)
                this._UserInterface!.printMessage(item.ToString(), true);

            string name = this._UserInterface!.getData("Выдать информацио о: ");

            if(this._Presenter!.Planer!.Purposes.Contains(new MyPurpose(name)))
            {
                var a = this._Presenter!.Planer!.Purposes.Find(x => x.Name == name);
                this._UserInterface.printMessage($"Дата создания: {a!.CreationDate}.", true);
                this._UserInterface.printMessage($"Название: {a.Name}.", true);
                var str = a.IfDone ? "Выполнена" : "Выполняется";
                this._UserInterface.printMessage($"Статус: {str}.", true);
                this._UserInterface.printMessage($"Задачи: ", true);
                foreach(var task in a.Tasks!)
                    this._UserInterface.printMessage(task.ToString(), true);
            }

        }
    }
}
