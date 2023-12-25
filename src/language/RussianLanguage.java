package language;

public class RussianLanguage implements LanguageInterface {
	
	@Override
    public String[] studentMenu() {
        return new String[] {
            "----Меню Студента----",
            "1 - Просмотр Транскрипта",
            "2 - Просмотр Оценок по Курсу",
            "3 - Регистрация на Курс",
            "4 - Просмотр Преподавателя по Курсу",
            "5 - Просмотр Всех Курсов",
            "6 - Оценить Преподавателей",
            "7 - Организация",
            "8 - Просмотр Новостей",
            "0 - Выйти"
        };
    }

	public String[] studentResearcherMenu() {
        return new String[] {
            "----Меню Исследователя-Студента----",
            "1 - Просмотр Транскрипта",
            "2 - Просмотр Оценок по Курсу",
            "3 - Регистрация на Курс",
            "4 - Просмотр Преподавателя по Курсу",
            "5 - Просмотр Всех Курсов",
            "6 - Оценить Преподавателей",
            "7 - Организация",
            "8 - Просмотр Новостей",
            "9 - Посмотреть меню исследователя",
            "0 - Выйти"
        };
    }

	@Override
	public String[] teacherMenu() {
		return new String[] {
	            "----Меню Учителя----",
	            "1 - Просмотр курсов",
	            "2 - Просмотр студентов",
	            "3 - Просмотр оценок",
	            "4 - Поставить оценки",
	            "5 - Оценка просмотров",
	            "6 - Просмотреть одну новость",
	            "7 - Отправить заказ",
	            "8 - Отправить запрос",
	            "9 - Выйти"
	        };
		
	}

	@Override
	public String[] teacherResearcherMenu() {
		// TODO Auto-generated method stub
		return new String[] {
	            "----Меню Исследователя-Учителя----",
	            "1 - Просмотр курсов",
	            "2 - Просмотр студентов",
	            "3 - Просмотр оценок",
	            "4 - Поставить оценки",
	            "5 - Оценка просмотров",
	            "6 - Просмотреть одну новость",
	            "7 - Отправить заказ",
	            "8 - Отправить запрос",
	            "9 - Выйти",
	            "10 - Посмотреть меню исследователя"
	        };
	}

	@Override
	public String[] adminMenu() {
		// TODO Auto-generated method stub
		return new String[] {
				"----Меню Админа----",
				"1 - Создать нового пользователья", 
				"2 - Посмотреть всех пользователей", 
				"3 - Обновить информацию о пользователе", 
				"4 - Удалить пользователья", 
				"5 - Просмотреть файлы журналов",
				"6 - Просмотреть одну новость", 
				"7 - Выйти"
		};
	}

	@Override
	public String[] managerMenu() {
		// TODO Auto-generated method stub
		return new String[] { 
				"----Меню Менеджера----",
				"1 - Создать статистический отчет", 
				"2 - Добавить курс", 
				"3 - Добавить урок учителю", 
				"4 - Создать новость",
				"5 - Просмотр запросов", 
				"6 - Редактировать новость", 
				"7 - Назначить курс учителю", 
				"8 - Просмотр студентов", 
				"9 - Просмотр учителей", 
				"10 - Создать журнал",
				"11 - Выйти" 
		};
	}

	@Override
	public String[] managerResearcherMenu() {
		// TODO Auto-generated method stub
		return new String[] { 
				"----Меню Исследователя-Менеджера----",
				"1 - Создать статистический отчет", 
				"2 - Добавить курс", 
				"3 - Добавить урок учителю", 
				"4 - Создать новость",
				"5 - Просмотр запросов", 
				"6 - Редактировать новость", 
				"7 - Назначить курс учителю", 
				"8 - Просмотр студентов", 
				"9 - Просмотр учителей", 
				"10 - Создать журнал",
				"11 - Выйти",
				"12 - Посмотреть меню исследователя"
		};
	}

	@Override
	public String[] techSupportSpecialistMenu() {
		// TODO Auto-generated method stub
		return new String[] {
				"----Меню специалиста техподдержки----  ",
				"1 - Просмотр заказов",
				"2 - Принять заказ", 
				"3 - Отклонить заказ", 
				"4 - Выйти" 
				};
	}

	@Override
	public String[] techSupportSpecialistResearcherMenu() {
		// TODO Auto-generated method stub
		return new String[] {
				"----Меню Исследователя-специалиста техподдержки----  ",
				"1 - Просмотр заказов",
				"2 - Принять заказ", 
				"3 - Отклонить заказ", 
				"4 - Выйти",
				"5 - Посмотреть меню исследователя"
				};
	}

	@Override
	public String[] deanMenu() {
		// TODO Auto-generated method stub
		return new String[] {
				"----Меню Декана----",
				"1 - Просмотреть все запросы",
				"2 - Подписать запросы", 
				"3 - Просмотреть одну новость", 
				"4 - Выйти"
		};
	}

	@Override
	public String[] deanResearcherMenu() {
		// TODO Auto-generated method stub
		return new String[] {
				"----Меню Исследователя-Декана----",
				"1 - Просмотреть все запросы",
				"2 - Подписать запросы", 
				"3 - Просмотреть одну новость", 
				"4 - Выйти",
				"5 - Посмотреть меню исследователя"
		};
	}

	@Override
	public String[] graduateStudentMenu() {
		// TODO Auto-generated method stub
		return new String[] { 
				"----Меню Аспиранта----",
				"1 - Просмотреть стенограмму", 
				"2 - Просмотр оценок за курс", 
				"3 - Регистрация на курс",
				"4 - Просмотреть учителя курса", 
				"5 - Просмотреть все курсы", 
				"6 - Оцените учителей", 
				"7 - Организация", 
				"8 - Просмотреть одну новость", 
				"9 - Выйти", 
				"10 - Посмотреть меню исследователя" 
				};
	}

	@Override
	public String[] employeeMenu() {
		// TODO Auto-generated method stub
		return new String[]{
				"----Меню Cотрудника----",
				"1 - Отправить запрос", 
				"2 - Отправить заказ", 
				"3 - Просмотреть одну новость", 
				"4 - Выйти"
				};
	}

	@Override
	public String[] employeeResearcherMenu() {
		// TODO Auto-generated method stub
		return new String[]{
				"----Меню Исследователя-Cотрудника----",
				"1 - Отправить запрос", 
				"2 - Отправить заказ", 
				"3 - Просмотреть одну новость", 
				"4 - Выйти", 
				"5 - Просмотреть меню исследователя"
				};
	}

	@Override
	public String[] researcherMenu() {
		// TODO Auto-generated method stub
		return new String[] {
				"----Меню Исследователя----",
				"1 - Просмотр документов", 
				"2 - Создать бумагу", 
				"3 - Просмотр проектов", 
				"4 - Просмотр журналов", 
				"5 - Добавить статью в журнал", 
				"6 - Выйти"
		};
	}

	
}
