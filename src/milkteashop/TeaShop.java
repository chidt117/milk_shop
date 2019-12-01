package milkteashop;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class TeaShop implements Shop{
	private List<Bubble> bubbleList = new ArrayList<Bubble>();
	private List<Coconut> coconutList = new ArrayList<Coconut>();
	private List<MilkTea> milkTeas = new ArrayList<MilkTea>();
	int count = 0;//用来数奶茶数，用于奶茶命名
	
/**
 * 进货，利用重载
 * 	
 */
	private void addIn(Bubble b)
	{
		bubbleList.add(b);
		System.out.println("成功进货一份珍珠");
	}
	
	private void addIn(Coconut c) {
		coconutList.add(c);
		System.out.println("成功进货一份椰果");
	}

	public void addIngredient(Ingredient ingredient) {
		if(ingredient instanceof Bubble)
			addIn((Bubble) ingredient);
		if(ingredient instanceof Coconut)
			addIn((Coconut) ingredient);
		
	}
	/**
	 * 制作奶茶
	 * @throws SoldOutException 
	 */
	
	public void make(String ingreName)
	{
		count++;
		MilkTea tea = new MilkTea();
		tea.setName("奶茶" + count);
//		System.out.println(tea.getName());//测试用
//		tea.setIngredient(null);
		tea.setIngreName(ingreName);
		milkTeas.add(tea);
	}
	
	
	
	public void makeTea(String ingreName) throws SoldOutException {
		/*
		 * 先判断有没有配料，有配料再制作
		 */
		/*
		 * 同时还要判断配料是否过期
		 */
		if(ingreName.equals(Bubble.NAME))
		{
			if(bubbleList.size()!=0)
			{
				//判断配料是否过期
				while(bubbleList.get(0).isOutDate())
					bubbleList.remove(0);
			}
			if(bubbleList.size() == 0)
			{
				System.out.println("珍珠缺货");
				throw new SoldOutException();
			}
			make(ingreName);
			System.out.println("制作一杯珍珠奶茶");
			bubbleList.remove(0);//移除配料
		}
		else if(ingreName.equals(Coconut.NAME))
		{
			if(coconutList.size()!=0)
			{
				//判断配料是否过期
				while(coconutList.get(0).isOutDate())
					coconutList.remove(0);
			}
			if(coconutList.size() == 0)
			{
				System.out.println("椰果缺货");
				throw new SoldOutException();
			}
			make(ingreName);
			System.out.println("制作一杯椰果奶茶");
			coconutList.remove(0);//移除配料
		}
		

		
	}
	/**
	 * 卖奶茶
	 * 
	 */
	

	public void sellTea(String teaName, String ingreName) {


		
		MilkTea t = null;
		if (milkTeas == null || milkTeas.size() == 0) {
			System.out.println(ingreName + "奶茶:"+teaName+"未制作，列表为空! " );
			return;
		}

		for (MilkTea tea: milkTeas) {
			if (tea.getName().equals(teaName)&&ingreName.equals(tea.getIngreName())) {
				t = tea;
//				System.out.println("YES!");//用来测试
				milkTeas.remove(t);
				System.out.println("成功卖出一杯: " + teaName + ", 为: " + ingreName+"奶茶");
			}
			else {
				System.out.println(ingreName + "奶茶:"+teaName+"未制作，未找到同名奶茶或配料不对! " );
				return;
			}

	}
		
	
}
	
	
	//随机进货
	public void add_random_num(int i)//i代表随机进货的数量
	{
//		Bubble b = new Bubble(Calendar.getInstance());
//		Coconut c = new Coconut(Calendar.getInstance());
		for(int n=1;n<=i;n++)
		{
			Random r = new Random();
			if(r.nextBoolean())
			{
				addIngredient(new Bubble(Calendar.getInstance()));//开始创建即获得生产日期
			}
			else
			{
				addIngredient(new Coconut(Calendar.getInstance()));//开始创建即获得生产日期
			}
		}
	}
	
	
	
	
	
	
	
}
