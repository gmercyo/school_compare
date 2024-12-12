-- This is a very abbreviated seed. Will vastly expand it later, but wanted to test with just a few schools.
DELETE FROM schools;

INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Ambler Primary School and Children''s Centre',
    'Blackstock Road, N4 2DR',
    -0.101753,
    51.5625992,
    '[{"year": "''24-''25", "radius": 0.290}, {"year": "''23-''24", "radius": 0.393}, {"year": "''22-''23", "radius": 0.289}]',
    4,
    'https://files.ofsted.gov.uk/v1/file/50215756',
    'primary',
    'mixed',
    'n/a',
    'community',
    'www.amblerprimaryschool.co.uk');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Gillespie Primary School',
    'Gillespie Road, N5 1LH',
    -0.10007,
    51.5600014,
    '[{"year": "''24-''25", "radius": 0.148}, {"year": "''23-''24", "radius": 0.148}, {"year": "''22-''23", "radius": 0.141}]',
    4,
    'https://files.ofsted.gov.uk/v1/file/50235575',
    'primary',
    'mixed',
    'n/a',
    'community',
    'https://www.gillespie.islington.sch.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'St John''s Highbury Vale CofE Primary School',
    'Conewood Street, N5 1DL',
    -0.10078,
    51.5582008,
    '[{"year": "''24-''25", "radius": 0.351}, {"year": "''23-''24", "radius": 0.21}, {"year": "''22-''23", "radius": 0.28}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50232508',
    'primary',
    'mixed',
    'n/a',
    'community',
    'https://www.stjohnevangelist.co.uk');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'St Joan of Arc RC Primary School',
    'Northolme Road, N5 2UX',
    -0.0970096,
    51.5565987,
    '[{"year": "''24-''25", "radius": 0.55}, {"year": "''23-''24", "radius": 0.33}, {"year": "''22-''23", "radius": 0.2}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50241024',
    'primary',
    'mixed',
    'n/a',
    'catholic',
    'https://www.st-joanofarc.islington.sch.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Highbury Quadrant Primary School',
    'Highbury New Park, N5 2DP',
    -0.0918841,
    51.5540009,
    '[{"year": "''24-''25", "radius": -1}, {"year": "''23-''24", "radius": -1}, {"year": "''22-''23", "radius": -1}]',
    2,
    'https://files.ofsted.gov.uk/v1/file/50228420',
    'primary',
    'mixed',
    'n/a',
    'community',
    'www.highburyquadrantprimary.co.uk');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Highbury Fields School',
    'Highbury Hill, N5 1AR',
    -0.101539,
    51.5527992,
    '[{"year": "''24-''25", "radius": 0.974}, {"year": "''23-''24", "radius": 0.787}, {"year": "''22-''23", "radius": 0.893}]',
    4,
    'https://files.ofsted.gov.uk/v1/file/50198766',
    'secondary',
    'girls',
    'n/a',
    'community',
    'http://www.highburyfields.islington.sch.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Elizabeth Garrett Anderson School',
    'Donegal Street, N1 9QG',
    -0.112659,
    51.5330009,
    '[{"year": "''24-''25", "radius": 1.082}, {"year": "''23-''24", "radius": 1.506}, {"year": "''22-''23", "radius": 0.873}]',
    4,
    'https://files.ofsted.gov.uk/v1/file/2447618',
    'secondary',
    'girls',
    'n/a',
    'community',
    'https://www.egaschool.co.uk/');
