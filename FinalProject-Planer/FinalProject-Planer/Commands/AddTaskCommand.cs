using FinalProject_Planer.Commands.Base;

namespace FinalProject_Planer.Commands
{
    public class AddTaskCommand : PlanerCommand
    {
        private IUserInterface? _UserInterface;
        private Presenter? _Presenter;

        public AddTaskCommand(IUserInterface? userInterface, Presenter? presenter)
        {
            _UserInterface = userInterface;
            _Presenter = presenter;
        }

        public override string? Describe => "Добавить задачу";

        public override void Execute(string[] args)
        {
            _Presenter!.Planer!.AddTask(new MyTask(_UserInterface!.getData("Название: ")));
            _Presenter.Save();
        }
    }
}
