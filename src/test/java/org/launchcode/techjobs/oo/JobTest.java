package org.launchcode.techjobs.oo;

import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId(){

        Job job1= new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(),job2.getId());

    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job1.getName().equals("Product tester"));
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(job1.getName(), "Product tester");
        assertEquals(job1.getEmployer().getValue(), "ACME");
        assertEquals(job1.getLocation().getValue(), "Desert");
        assertEquals(job1.getPositionType().getValue(), "Quality control");
        assertEquals(job1.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job jobForEquality1 =  new Job("Software Engineer", new Employer("ABC"), new Location("New York"), new PositionType("Quality control"), new CoreCompetency("Reviewer"));
        Job jobForEquality2 =  new Job("Software Engineer", new Employer("ABC"), new Location("New York"), new PositionType("Quality control"), new CoreCompetency("Reviewer"));
        assertNotEquals(jobForEquality2.getId(), jobForEquality1.getId());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"), new PositionType("Back-end developer"), new CoreCompetency("Java"));

       assertTrue((job.toString().startsWith(System.lineSeparator())));
        assertTrue((job.toString().endsWith(System.lineSeparator())));
    }


    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expectedValue = System.lineSeparator()+
                 "ID: "+job.getId()+
                "\nName: "+job.getName()+
                "\nEmployer: "+job.getEmployer().getValue()+
                "\nLocation: "+job.getLocation().getValue()+
                "\nPosition Type: "+job.getPositionType().getValue()+
                "\nCore Competency: "+job.getCoreCompetency().getValue()+System.lineSeparator();
        assertEquals(expectedValue,job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Web Developer", new Employer(""), new Location("StL"), new PositionType(""), new CoreCompetency("Java"));
        String expectedValue =System.lineSeparator()+"ID: "+job.getId()+
                "\nName: "+job.getName()+"\nEmployer: Data not available"+
                "\nLocation: "+job.getLocation().getValue()+"\nPosition Type: Data not available"+"\nCore Competency: "
                +job.getCoreCompetency().getValue()+System.lineSeparator();
        assertEquals(expectedValue, job.toString());
    }

    @Test
    public void testToStingHanldesOnlyIdField(){
        Job job = new Job();
        assertEquals(job.toString(), "OOPS! This job does not seem to exist.");
    }


}
