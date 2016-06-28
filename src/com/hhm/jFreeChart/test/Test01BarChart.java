package com.hhm.jFreeChart.test;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * 尝试利用JFreeChart来绘画一个柱状图
 * @author 黄帅哥
 *
 */
public class Test01BarChart {

	public static void main(String[] args) {
		//准备数据
		//创建数据模型对象DefaultCategoryDataset
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		
		//加入数据，中国数据
		dataset.addValue(12, "中国", "北京");//位于中国北京的部门有12个人
		dataset.addValue(10, "中国", "上海");//位于中国上海的部门有10个人
		dataset.addValue(5, "中国", "广州");//位于中国广州的部门有5个人
		
		//加入数据，美国数据
		dataset.addValue(10, "美国", "纽约");
		dataset.addValue(5, "美国", "洛杉矶");
		dataset.addValue(3, "美国", "西雅图");
		
		//2 创建图表对象(3d柱状图 举例)
		JFreeChart chart=ChartFactory.createBarChart3D(
				"各单位柱状图",//图形的标题title
				"单位",//x轴标签 categoryAxisLabel
				"人数", //y轴标签valueAxisLabel
				dataset, //数据
				PlotOrientation.VERTICAL, //图表的方向orientation，垂直方向
				true, //是否显示图示案例legend
				true,//是否显示工具tooltips
				true);//是否生成链接urls
		
		
		//设置样式
		//处理中文乱码
		Font titleFont=new Font("宋体", Font.BOLD, 18);//标题字体的样式
		Font labelFont=new Font("宋体", Font.BOLD, 15);//标签字体的样式
		
//		chart.getTitle().setFont(titleFont);//设置标题样式
//		
//		chart.getLegend().setItemFont(labelFont);//图示案例的字体
		
		// 字体
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(titleFont);

		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(labelFont);
		
		//获取绘画区域
		CategoryPlot plot=(CategoryPlot) chart.getPlot();
		
		//获取x轴对象
		CategoryAxis x=plot.getDomainAxis();
		x.setLabelFont(labelFont);//设置x轴标签字体
		x.setTickLabelFont(labelFont);//设置x轴刻度字体
		
		//获取y轴对象
		ValueAxis y=plot.getRangeAxis();
		y.setLabelFont(labelFont);//设置y轴字体
		
		//获取着色区域对象
		BarRenderer3D renderer=(BarRenderer3D) plot.getRenderer();
		//显示柱子标签
		renderer.setBaseItemLabelsVisible(true);
		//在柱子上显示数字
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());

		//设置柱子的最大宽度
		renderer.setMaximumBarWidth(0.07);//7%的意思
		
		//把图表显示出来
		ChartFrame frame=new ChartFrame("", chart);//加入图表信息
		frame.setVisible(true);//显示可见
		frame.pack();//打包
	}
}
