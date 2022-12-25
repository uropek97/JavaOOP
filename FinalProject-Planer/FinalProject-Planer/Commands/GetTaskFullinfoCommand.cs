using FinalProject_Planer.Commands.Base;

namespace FinalProject_Planer.Commands
{
    public class GetTaskFullinfoCommand : PlanerCommand
    {
        private IUserInterface? _UserInterface;
        private Presenter? _Presenter;

        public GetTaskFullinfoCommand(IUserInterface? userInterface, Presenter? presenter)
        {
            _UserInterface = userInterface;
            _Presenter = presenter;
        }

        public override string? Describe => "Выдаёт полную информацию о задачи.";

        public override void Execute(string[] args)
        {
            foreach (var item in this._Presenter!.Planer!.Tasks!)
                this._UserInterface!.printMessage(item.ToString(), true);

            string name = this._UserInterface!.getData("Выдать информацио о: ");

            if (this._Presenter!.Planer!.Tasks.Contains(new MyTask(name)))
            {
                var a = this._Presenter!.Planer!.Tasks.Find(x => x.Name == name);
                this._UserInterface.printMessage($"Дата создания: {a!.CreationDate}.", true);
                this._UserInterface.printMessage($"Название: {a.Name}.", true);
                var str = a.IfDone ? "Выполнена" : "Выполняется";
                this._UserInterface.printMessage($"Статус: {str}.", true);
            }
        }
    }
}
