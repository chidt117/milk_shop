package milkteashop;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class TeaShop implements Shop{
	private List<Bubble> bubbleList = new ArrayList<Bubble>();
	private List<Coconut> coconutList = new ArrayList<Coconut>();
	private List<MilkTea> milkTeas = new ArrayList<MilkTea>();
	int count = 0;//�������̲����������̲�����
	
/**
 * ��������������
 * 	
 */
	private void addIn(Bubble b)
	{
		bubbleList.add(b);
		System.out.println("�ɹ�����һ������");
	}
	
	private void addIn(Coconut c) {
		coconutList.add(c);
		System.out.println("�ɹ�����һ��Ҭ��");
	}

	public void addIngredient(Ingredient ingredient) {
		if(ingredient instanceof Bubble)
			addIn((Bubble) ingredient);
		if(ingredient instanceof Coconut)
			addIn((Coconut) ingredient);
		
	}
	/**
	 * �����̲�
	 * @throws SoldOutException 
	 */
	
	public void make(String ingreName)
	{
		count++;
		MilkTea tea = new MilkTea();
		tea.setName("�̲�" + count);
//		System.out.println(tea.getName());//������
//		tea.setIngredient(null);
		tea.setIngreName(ingreName);
		milkTeas.add(tea);
	}
	
	
	
	public void makeTea(String ingreName) throws SoldOutException {
		/*
		 * ���ж���û�����ϣ�������������
		 */
		/*
		 * ͬʱ��Ҫ�ж������Ƿ����
		 */
		if(ingreName.equals(Bubble.NAME))
		{
			if(bubbleList.size()!=0)
			{
				//�ж������Ƿ����
				while(bubbleList.get(0).isOutDate())
					bubbleList.remove(0);
			}
			if(bubbleList.size() == 0)
			{
				System.out.println("����ȱ��");
				throw new SoldOutException();
			}
			make(ingreName);
			System.out.println("����һ�������̲�");
			bubbleList.remove(0);//�Ƴ�����
		}
		else if(ingreName.equals(Coconut.NAME))
		{
			if(coconutList.size()!=0)
			{
				//�ж������Ƿ����
				while(coconutList.get(0).isOutDate())
					coconutList.remove(0);
			}
			if(coconutList.size() == 0)
			{
				System.out.println("Ҭ��ȱ��");
				throw new SoldOutException();
			}
			make(ingreName);
			System.out.println("����һ��Ҭ���̲�");
			coconutList.remove(0);//�Ƴ�����
		}
		

		
	}
	/**
	 * ���̲�
	 * 
	 */
	

	public void sellTea(String teaName, String ingreName) {


		
		MilkTea t = null;
		if (milkTeas == null || milkTeas.size() == 0) {
			System.out.println(ingreName + "�̲�:"+teaName+"δ�������б�Ϊ��! " );
			return;
		}

		for (MilkTea tea: milkTeas) {
			if (tea.getName().equals(teaName)&&ingreName.equals(tea.getIngreName())) {
				t = tea;
//				System.out.println("YES!");//��������
				milkTeas.remove(t);
				System.out.println("�ɹ�����һ��: " + teaName + ", Ϊ: " + ingreName+"�̲�");
			}
			else {
				System.out.println(ingreName + "�̲�:"+teaName+"δ������δ�ҵ�ͬ���̲�����ϲ���! " );
				return;
			}

	}
		
	
}
	
	
	//�������
	public void add_random_num(int i)//i�����������������
	{
//		Bubble b = new Bubble(Calendar.getInstance());
//		Coconut c = new Coconut(Calendar.getInstance());
		for(int n=1;n<=i;n++)
		{
			Random r = new Random();
			if(r.nextBoolean())
			{
				addIngredient(new Bubble(Calendar.getInstance()));//��ʼ�����������������
			}
			else
			{
				addIngredient(new Coconut(Calendar.getInstance()));//��ʼ�����������������
			}
		}
	}
	
	
	
	
	
	
	
}
