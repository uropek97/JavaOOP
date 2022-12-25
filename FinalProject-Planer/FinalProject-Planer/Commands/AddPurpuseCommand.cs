using FinalProject_Planer.Commands.Base;

namespace FinalProject_Planer.Commands
{
    public class AddPurpuseCommand : PlanerCommand
    {
        public IUserInterface? _UserInterface;
        public Presenter? _Presenter;

        public AddPurpuseCommand(IUserInterface? userInterface, Presenter? presenter)
        {
            _UserInterface = userInterface;
            _Presenter = presenter;
        }

        public override string? Describe => "Добавить цель.";

        public override void Execute(string[] args)
        {
            _Presenter!.Planer!.AddPurpose(new MyPurpose(_UserInterface.getData("Название: ")));
            _Presenter.Save();
        }
    }
}
