using FinalProject_Planer.Commands;
using FinalProject_Planer.Commands.Base;

namespace FinalProject_Planer
{
    public class Presenter
    {
        private Planer? _Planer;
        private readonly IUserInterface? _UserInterface;
        private readonly IMyFileHelper? _FileHelper;
        private bool _CanWork;

        public Planer? Planer { get { return _Planer; } set { _Planer = value; } }

        public IReadOnlyDictionary<string, PlanerCommand>? Commands { get; }

        public Presenter(IUserInterface? userInteface, IMyFileHelper fileHelper)
        {
            this._UserInterface = userInteface;
            this._FileHelper = fileHelper;
            this.Planer = this._FileHelper.Read();
            this._CanWork = true;

            var help = new HelpCommand(this._UserInterface, this);
            var exit = new ExitCommand(this);
            var addPurpComm = new AddPurpuseCommand(this._UserInterface, this);
            var addTaskComm = new AddTaskCommand(this._UserInterface, this);
            this.Commands = new Dictionary<string, PlanerCommand>()
            {
                {"help", help },
                {"?", help },
                {"exit", exit },
                {"quit", exit },
                {"PrintAll", new PrintAllCommand(this._UserInterface!, this) },
                {"AddPurpuse", addPurpComm },
                {"AddP", addPurpComm },
                {"AddTask", addTaskComm },
                {"AddT", addTaskComm },
                {"RemoveP", new RemovePurposeCommand(this._UserInterface, this) },
                {"RemoveT", new RemoveTaskCommand(this._UserInterface, this) },
                {"GetInfoP", new GetPurouseFullinfoCommand(this._UserInterface, this) },
                {"GetInfoT", new GetTaskFullinfoCommand(this._UserInterface, this) },
                {"AddTaskToP", new AddTaskToPurposeCommand(this._UserInterface, this) },
            };
        }

        public void Work()
        {
            _UserInterface!.printMessage("Начало работы", true);

            do
            {
                var input = _UserInterface.getData("Введите команду: ");
                var args = input.Split(' ');
                var commandName = args[0];

                if (!Commands!.TryGetValue(commandName, out var command))
                {
                    _UserInterface.printMessage($"Неизвестная команда {commandName}.", true);
                    _UserInterface.printMessage($"Для справки - help, для выхода - quit", true);
                    continue;
                }
                try
                {
                    command.Execute(args);
                }
                catch (Exception e)
                {
                    _UserInterface.printMessage($"При выполнении команды {commandName} произошла ошибка;", true);
                    _UserInterface.printMessage(e.Message, true);
                }
            } while (this._CanWork);
        }

        public void Stop()
        {
            this._CanWork = false;
        }

        public void Save()
        {
            _FileHelper!.Write(this._Planer!);
        }
    }
}
