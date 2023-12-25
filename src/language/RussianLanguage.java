package language;

public class RussianLanguage implements LanguageInterface{

	@Override
	public void studentMenu() {
		// TODO Auto-generated method stub
		System.out.println("----Меню Студента----");
		System.out.println("1 - Просмотр Транскрипта");
		System.out.println("2 - Просмотр Оценок по Курсу");
		System.out.println("3 - Регистрация на Курс");
		System.out.println("4 - Просмотр Преподавателя по Курсу");
		System.out.println("5 - Просмотр Всех Курсов");
		System.out.println("6 - Оценить Преподавателей");
		System.out.println("7 - Организация");
		System.out.println("8 - Просмотр Новости");
		System.out.println("9 - Выйти");
		
	}

	@Override
	public void studentReseacherMenu() {
		// TODO Auto-generated method stub
		System.out.println("----Меню Студента-Исследователя----");
		System.out.println("0 - Выйти в основное меню");
		
	}

	@Override
	public void teacherMenu() {
		// TODO Auto-generated method stub
		System.out.println("----Меню Студента----");
		System.out.println("1 - Просмотр курсов");
		System.out.println("2 - Просмотр студентов");
		System.out.println("3 - Просмотр оценок");
		System.out.println("4 - Поставить оценки");
		System.out.println("5 - Оценка просмотров");
		System.out.println("6 - Просмотреть одну новость");
		System.out.println("7 - Отправить заказ");
		System.out.println("8 - Отправить запрос");
		System.out.println("9 - Выйти");
	}

	@Override
	public void teacherResearcherMenu() {
		// TODO Auto-generated method stub
		System.out.println("----Меню Учителя-Исследователя----");
		System.out.println("0 - Выйти в основное меню");
	}

}
