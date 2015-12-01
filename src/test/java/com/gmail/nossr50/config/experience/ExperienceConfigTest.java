package com.gmail.nossr50.config.experience;

import static org.junit.Assert.*;

import java.io.*;
import java.util.Map;

import org.junit.*;

import com.gmail.nossr50.mcMMO;
import com.gmail.nossr50.datatypes.experience.FormulaType;
import com.esotericsoftware.yamlbeans.*;


public class ExperienceConfigTest {

	mcMMO mcMMOtest;
	ExperienceConfig instance;
	FileReader exp;
    YamlReader reader;
    
	@Before
	public void initialize() {
		mcMMOtest.onEnable();
		instance = ExperienceConfig.getInstance();
		
		try {
		exp = new FileReader("experience.yml");
	    reader = new YamlReader(exp);
		}
		catch (FileNotFoundException ex) {
			
		}
	} 
	
	@Test
	public void test_FormulaType() throws YamlException {
		Object object = reader.read();
		Map map = (Map) object;
		FormulaType f1 = (FormulaType) map.get("Experience_Formula.Curve.DEFAULT");
		
		FormulaType f2 = instance.getFormulaType();
		assertEquals(f2, f1);
	}

}
